public class Medicine {
    private String name;///торговое название
    private String compudence;///главный действующий элемент
    private int sum;
    private int index;
    public Medicine(String name, String compudence, int sum, int index) {
        this.name = name;
        this.compudence = compudence;
        this.sum = sum;
        this.index = index;
    }
    public String getName() {
        return name;
    }

    public String getCompudence() {
        return compudence;
    }

    public int getSum() {
        return sum;
    }

    public int getIndex() {
        return index;
    }


}
