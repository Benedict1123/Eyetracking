public class RectBlock {

    private int width;
    private int height;
    private int startX;
    private int startY;
    private String block_index;

    public RectBlock(int width, int height, int startX, int startY,String block_index) {
        this.width = width;
        this.height = height;
        this.startX = startX;
        this.startY = startY;
        this.block_index = block_index;
    }


    //判断是否在矩形内部
    public boolean isInside(int x,int y)
    {
        if(x>=startX&&x<=(startX+width)&&y>startY&&y<=(startY+height))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
