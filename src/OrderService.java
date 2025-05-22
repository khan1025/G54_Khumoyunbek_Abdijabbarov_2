public class OrderService {

     int orderCount;

    public void increaseOrderCount() {
        synchronized (this) {
            this.orderCount += 1;
        }
    }

    public int getOrderCount() {
        return orderCount;
    }

}
