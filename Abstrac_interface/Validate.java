package Abstrac_interface;

import java.util.List;

public interface Validate {
    void display(List<Material> materials);
    void addM(List<Material> materials);
    void remove(List<Material> materials, int i);
    void Edit(List<Material> materials, int m);
}
