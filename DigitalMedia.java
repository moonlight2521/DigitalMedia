//***********************************************************************************************************
//Zun Lin
//DigitalMedia
//This program is to create a datebase of different digital media with different size and name. 
//************************************************************************************************************

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class DigitalMedia 
{
// Instance Variables:
 private String name;
 private long size;
 private LocalDateTime dateCreated;
 private LocalDateTime dateModified;
 private String createdString;
 private String modifiedString;
 private DateTimeFormatter formatter;
 private String monthString;
 private String date;
 
//Parameterized Constructor*********************************************************************************************
 public DigitalMedia(String aName, long aSize)
 {
   setName(aName);
   setSize(aSize);
   dateCreated = LocalDateTime.now();                       //created a LocalDateTime 
   formatter = DateTimeFormatter.ofPattern("L dd, yyyy");         //format DateTimeFormatter to String "L dd, yyyy"
   date = dateCreated.format(formatter);                             //change dateModified to the formatter
   createdString = month(date) + date.substring(2,date.length());         //change the format of LocalDateTime
   
   dateModified = LocalDateTime.now();                        //created a LocalDateTime 
   formatter = DateTimeFormatter.ofPattern("L dd, yyyy");            //format DateTimeFormatter to String "L dd, yyyy"
   date = dateModified.format(formatter);                                 //change dateModified to the formatter
   modifiedString = month(date) + date.substring(2,date.length());            //change the format of LocalDateTime
 }
//Method for month name
 public String month(String dates)
 {
   String m = dates.substring(0,2);        //get the string at 1 of dates to change to words
   switch (m)                              //switch for different numbers
   {
     case "1 ": monthString = "January ";
     break;
     case "2 ": monthString = "February ";
     break;
     case "3 ": monthString = "March ";
     break;
     case "4 ": monthString = "April ";
     break;
     case "5 ": monthString = "May ";
     break;
     case "6 ": monthString = "June ";
     break;
     case "7 ": monthString = "July ";
     break;    
     case "8 ": monthString = "August ";
     break;
     case "9 ": monthString = "September ";
     break;
     case "10": monthString = "October";
     break;
     case "11": monthString = "November";
     break;
     case "12": monthString = "December";
     break;
   }
   return monthString;
 }
//Mutator Methods*******************************************************************************************************
//Set Name
 public void setName(String aName)
 {

   if(aName == null)
   {
     throw new NullPointerException("Name cannot be null.");
   }
   else if(aName.equals(""))
   {
     throw new IllegalArgumentException("Please Enter the Name");
   }
   else if(!aName.contains("."))
   {
     throw new IllegalArgumentException("Invalid Name");
   }
   else if(aName.indexOf('.', aName.indexOf('.') + 1 ) != -1)
   {
     throw new IllegalArgumentException("Invalid Name");
   }
   else
   {
     name = aName;
   }
 }
//Set size;

 public void setSize(long aSize)
 {
  
  if(aSize < 0)
  {
   throw new IllegalArgumentException("Invalid Size");
  }
  else
  {
    size = aSize;
  }
 }
 //Set Date Modified
  public void setDateModified(LocalDateTime setDate)
  {
    if(setDate.isAfter(dateCreated))
    {
      dateModified = setDate;        
      formatter = DateTimeFormatter.ofPattern("L dd, yyyy");         //format DateTimeFormatter to String "L dd, yyyy"
      date = dateModified.format(formatter);                         //change dateModified to the formatter
      modifiedString = month(date) + date.substring(2,date.length());   //change the format of LocalDateTime
    }
    else
    {
      throw new IllegalArgumentException("Date modified must be after date created");
    }
  }
 
//Accessor Mathods******************************************************************************************************
 
//Get Name
 public String getName()
 {
   return name;
 }
//Get size
 public long getSize()
 {
   return size;
 }
//Get Date Created
 public String getDateCreated()
 {
   return createdString;
 }
//Get Date Modified
 public String getDateModified()
 {
   return modifiedString;
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
   if((obj instanceof DigitalMedia))      //different class
   {
     DigitalMedia other = (DigitalMedia) obj;    //cast then compare data members
     
     if(name.equals(other.getName()) && size == other.getSize() && dateModified.equals(other.getDateModified()) )
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
   output = "\nName: "+name+"\nSize: "+size+" KB"+"\nCreated: "+createdString+ "\nModified: "+modifiedString;
   return output;
 }
}
