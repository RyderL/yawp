package ${yawpPackage}.models.${endpoint.packageName};

import io.yawp.repository.IdRef;
import io.yawp.repository.annotations.Endpoint;
import io.yawp.repository.annotations.Id;

@Endpoint(path = "/$endpoint.path")
public class $endpoint.name {

	@Id
	private IdRef<$endpoint.name> id;

	public IdRef<$endpoint.name> getId() {
		return id;
	}

	public void setId(IdRef<$endpoint.name> id) {
		this.id = id;
	}

}
