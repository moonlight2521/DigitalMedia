//***********************************************************************************************************
//Zun Lin
//Image subclass
//his program is to create a subclass of DigitalMedia class of different image with different width and height.
//************************************************************************************************************
public class Image extends DigitalMedia implements Comparable<Image>{
    private int width;
    private int height;


    public Image(String aName, long aSize,  int aWidth, int aHeight)
    {
        super(aName, aSize);
        setHeight(aHeight);
        setWidth(aWidth);
    }
    //Comparable Interface*********************************************************************************************
    public int compareTo(Image o){
    return this.getName().toLowerCase().compareTo(o.getName().toLowerCase());
    }

    //Mutator Methods****************************************************************************************************
    //Set width
    public void setWidth(int width) {
        if(width <= 0)
        {
            throw new IllegalArgumentException("Invalid width");
        }
        else
        {
            this.width = width;
        }
    }
    //Set height
    public void setHeight(int height) {
        if(height <= 0)
        {
            throw new IllegalArgumentException("Invalid height");
        }
        else
        {
            this.height = height;

        }
    }
    //Accessor Methods******************************************************************************************************
    //Get width
    public int getWidth() {
        return width;
    }
    //Get height
    public int getHeight() {
        return height;
    }
    //Equals Method*********************************************************************************************************
    public boolean equals(Object obj)
    {
        boolean areEqual = false;
        if(this == obj)          //the same object
        {
            areEqual = true;
        }
        if(obj == null)    //Null argument
        {
            return areEqual;
        }
        if((obj instanceof Image))      //different class
        {
            Image other = (Image) obj;    //cast then compare data members

            if(super.getName().equals(other.getName()) && super.getSize()== other.getSize() &&
                    width == other.getWidth() && height == other.getHeight())
            {
                areEqual = true;
            }
        }
        return areEqual;
    }
    //Return the value******************************************************************************************************
    public String toString()
    {
        String output;
        output = "\nTitle: "+super.getName()+"\nwidth: "+width+"\nheight: "+height;
        return output;
    }
}
