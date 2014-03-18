package endpoint;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import endpoint.Repository;
import endpoint.utils.DateUtils;
import endpoint.utils.GAETest;

public class RepositoryTest extends GAETest {

	private Repository r;

	@Before
	public void before() {
		r = new Repository();
	}

	@Test
	public void testSave() {
		SimpleObject object = new SimpleObject(1, 1l, 1.1, true, DateUtils.toTimestamp("2013/12/26 23:55:01"), "object1");

		r.save(object);
		object = r.findByKey(object.getKey(), SimpleObject.class);

		object.assertObject(1, 1l, 1.1, true, "2013/12/26 23:55:01", "object1");
	}

	@Test
	public void testSaveWithList() {
		SimpleObject object = new SimpleObject(1, 1l, 1.1, true, DateUtils.toTimestamp("2013/12/26 23:55:01"), "object1");
		object.setaList(Arrays.asList(new AnotherSimpleObject("anotherObject1")));

		r.save(object);
		object = r.findByKey(object.getKey(), SimpleObject.class);

		object.assertObject(1, 1l, 1.1, true, "2013/12/26 23:55:01", "object1");
		assertEquals(1, object.getaList().size());
		assertEquals("anotherObject1", object.getaList().get(0).getaString());
	}

	@Test
	public void testSaveTwoObjectsWithList() {
		SimpleObject object1 = new SimpleObject(1, 1l, 1.1, true, DateUtils.toTimestamp("2013/12/26 23:55:01"), "object1");
		object1.setaList(Arrays.asList(new AnotherSimpleObject("anotherObject1")));

		SimpleObject object2 = new SimpleObject(2, 2l, 2.2, true, DateUtils.toTimestamp("2013/12/29 00:43:01"), "object2");
		object2.setaList(Arrays.asList(new AnotherSimpleObject("anotherObject2")));

		r.save(object1);
		r.save(object2);

		object1 = r.findByKey(object1.getKey(), SimpleObject.class);
		object2 = r.findByKey(object2.getKey(), SimpleObject.class);

		object1.assertObject(1, 1l, 1.1, true, "2013/12/26 23:55:01", "object1");
		assertEquals(1, object1.getaList().size());
		object1.getaList().get(0).assertAnotherObject("anotherObject1");

		object2.assertObject(2, 2l, 2.2, true, "2013/12/29 00:43:01", "object2");
		assertEquals(1, object2.getaList().size());
		object2.getaList().get(0).assertAnotherObject("anotherObject2");
	}

	@Test
	public void testFindById() {
		SimpleObject object = new SimpleObject(1, 1l, 1.1, true, DateUtils.toTimestamp("2013/12/26 23:55:01"), "object1");

		r.save(object);

		object = r.findById(1l, SimpleObject.class);
		object.assertObject(1, 1l, 1.1, true, "2013/12/26 23:55:01", "object1");

	}

	@Test
	public void testDontDuplicateChildList() {
		SimpleObject object = new SimpleObject(1, 1l, 1.1, true, DateUtils.toTimestamp("2013/12/26 23:55:01"), "object1");
		object.setaList(Arrays.asList(new AnotherSimpleObject("anotherObject1")));
		r.save(object);

		object = r.findByKey(object.getKey(), SimpleObject.class);
		object.setaList(Arrays.asList(new AnotherSimpleObject("anotherObject2")));
		r.save(object);

		object = r.findByKey(object.getKey(), SimpleObject.class);

		assertEquals(1, object.getaList().size());
		assertEquals("anotherObject2", object.getaList().get(0).getaString());
	}

}