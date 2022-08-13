public class GenenricPrinter<T extends Material>{
    private T material;

    public T getMateial() {
        return material;
    }

    public void setMaterial(T material) {
        this.material = material;
    }

    public String toString() {
        material.doPrinting();
        return material.toString();
    }
}
