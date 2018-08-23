package com.bilin.activemq.queue.producter;

public class TestProducter {
    public static void main(String[] args){
        Producter producter = new Producter();
        TestProducter testMq = new TestProducter();
        //Thread 1
        new Thread(testMq.new ProductorMq(producter)).start();
        new Thread(testMq.new ProductorMq(producter)).start();
    }

    private class ProductorMq implements Runnable{
        Producter producter;
        public ProductorMq(Producter producter){
            this.producter = producter;
        }

        @Override
        public void run() {
            while(true){
                try {
                    producter.sendMessage("Jaycekon-MQ");
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}