package hw5.shop.data;

/**
 * Implementation of Video interface.
 * @see Data
 */
final class VideoObj implements Video {
  private final String _title;
  private final int    _year;
  private final String _director;

  /**
   * Initialize all object attributes.
   * Title and director are "trimmed" to remove leading and final space.
   * @throws IllegalArgumentException if object invariant violated.
   */
  VideoObj(String title, int year, String director) {
    _title = title.intern();
    _director = director.intern();
    _year = year;
  }

  public String director() {  
    return _director;
  }

  public String title() {
	return _title;
  }

  public int year() {
    return _year;
  }

  public boolean equals(Object thatObject) {
	  if (thatObject==null) return false;
	    if (thatObject.getClass()!=VideoObj.class) return false;
	    VideoObj video = (VideoObj) thatObject;
	    if ((video.title().equals(this.title())) && (video.year()==this.year()) && (video.director().equals(this.director()))) return true;
	    return false;
  }

  public int hashCode() {
	  int result = 17;
	    result = 37*result + this._title.hashCode();
	    result = 37*result + this._year;
	    result = 37*result + this._director.hashCode();
	    return result;
  }

  public int compareTo(Object thatObject) {
	  VideoObj that = (VideoObj) thatObject;
	  int titleDiffer = _title.compareTo(that.title());
	  if (titleDiffer !=0) return titleDiffer;
	  int yearDiffer = Integer.compare(_year, that.year());
	  if (yearDiffer !=0) return yearDiffer;
	  int directorDiffer = _director.compareTo(that.director());
	  if (directorDiffer!=0) return directorDiffer;
	  return 0;
  }

  public String toString() {
	  StringBuilder buffer = new StringBuilder();
	  buffer.append(_title);
	  buffer.append(" (");
	  buffer.append(_year);
	  buffer.append(") : ");
	  buffer.append(_director);
	  return buffer.toString();
  }
}
