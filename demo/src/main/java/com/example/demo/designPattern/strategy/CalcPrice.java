package com.example.demo.designPattern.strategy;

public interface CalcPrice {

    Double calcPrice(Double originalPrice);

}

class Common implements CalcPrice{


    @Override
    public Double calcPrice(Double originalPrice) {
        return originalPrice;
    }

}

class Vip implements CalcPrice{

    @Override
    public Double calcPrice(Double originalPrice) {
        return originalPrice * 0.8;
    }
}

class SuperVip implements CalcPrice{

    @Override
    public Double calcPrice(Double originalPrice) {
        return originalPrice * 0.7;
    }
}

class GoldVip implements CalcPrice{
    @Override
    public Double calcPrice(Double originalPrice) {
        return originalPrice * 0.6;
    }
}

class Customer {

    private Double totalAmount = 0D;
    private Double amount = 0D;
    private CalcPrice calcPrice = new Common();

    public void buy(Double amount) {
        this.amount = amount;
        totalAmount += amount;
        if (totalAmount > 3000) {
            calcPrice = new GoldVip();
        } else if (totalAmount > 2000) {
            calcPrice = new SuperVip();
        } else if (totalAmount > 1000) {
            calcPrice = new Vip();
        }
    }

    public Double calLastAmount() {
        return calcPrice.calcPrice(amount);
    }

    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.buy(500D);
        System.out.println("客户需要付钱：" + customer.calLastAmount());
        customer.buy(1200D);
        System.out.println("客户需要付钱：" + customer.calLastAmount());
        customer.buy(1200D);
        System.out.println("客户需要付钱：" + customer.calLastAmount());
        customer.buy(1200D);
        System.out.println("客户需要付钱：" + customer.calLastAmount());
    }
}