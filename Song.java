//***********************************************************************************************************
//Zun Lin
//Song subclass
//This program is to create a subclass of DigitalMedia class of different songs with different size and title.
//************************************************************************************************************
public class Song extends DigitalMedia implements Comparable<Song>{
    private String artist;
    private String album;
    //Parameterized Constructor****************************************************************************************
    public Song (String aName, long aSize, String ar, String al)
    {
        super(aName, aSize);
        setArtist(ar);
        setAlbum(al);
    }
    //Comparable Interface*********************************************************************************************
    public int compareTo(Song o){
        int i = getArtist().toLowerCase().compareTo(o.getArtist().toLowerCase());
        if(i != 0) return i;
        i = getAlbum().toLowerCase().compareTo(o.getAlbum().toLowerCase());
        if(i != 0) return i;
        return getName().toLowerCase().compareTo(o.getName().toLowerCase());
    }
    //Mutator Methods**************************************************************************************************
    //Set artist
    public void setArtist(String artist) {
        if(artist == null)
        {
            throw new NullPointerException("artist cannot be null.");
        }
        else
        {
            this.artist = artist;
        }
    }
    //Set album
    public void setAlbum(String album) {
        if(album == null)
        {
            throw new NullPointerException("Album cannot be null.");
        }
        else
        {
            this.album = album;
        }
    }
    //Accessor Mathods******************************************************************************************************

    public String getArtist() {
        return artist;
    }

    public String getAlbum() {
        return album;
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
        if((obj instanceof Song))      //different class
        {
            Song other = (Song) obj;    //cast then compare data members

            if(super.getName().equals(other.getName()) && super.getSize()== other.getSize() &&
                    album.equals(other.getAlbum()) && artist.equals(other.getArtist()))
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
        output = "\nTitle: "+super.getName()+"\nArtist: "+artist+"\nAlbum: "+album;
        return output;
    }
}
