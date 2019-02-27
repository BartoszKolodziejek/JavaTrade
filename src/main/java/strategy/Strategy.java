package strategy;

import data.Candle;

public abstract class Strategy  {

    static boolean end = false;
    public static  Candle current = null;


    final void run() {
        this.init();
        while (!end){
            if (current != null){
                this.working();
                current = null;
            }
        }
        this.deinit();
    }


    /**
     * Initialization method to strategy (open streams, reading external sources etc.)
     */
    public abstract void init();

    /**
     * working state of strategy, doing until --stop
     */

    public abstract void working();

    /**
     * method on closing strategy, closing sockets, files etc.
     */

    public abstract void deinit();
}
