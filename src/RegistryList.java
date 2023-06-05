import java.io.Serializable;
import java.util.List;

public class RegistryList implements Serializable {
    private List<Registry> registryList;

    public RegistryList(List<Registry> registryList) {
        this.registryList = registryList;
    }

    public List<Registry> getRegistryList() {
        return registryList;
    }

    public void setRegistryList(List<Registry> registryList) {
        this.registryList = registryList;
    }
}
