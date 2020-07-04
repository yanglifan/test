package yanglifan.test.others.good_topn;

import java.util.Objects;

class Good {
    private String name;
    private Double price;

    public Good(String line) {
        String[] items = line.split("\t");
        this.name = items[0].trim();
        this.price = Double.valueOf(items[1].trim());
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Good good = (Good) o;
        return Objects.equals(name, good.name) &&
                Objects.equals(price, good.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
