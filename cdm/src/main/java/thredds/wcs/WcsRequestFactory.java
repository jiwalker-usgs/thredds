package thredds.wcs;

import ucar.nc2.dt.GridDataset;

/**
 * _more_
 *
 * @author edavis
 * @since 4.0
 */
public class WcsRequestFactory
{
  private Request request;

  private String versionString;
  private Request.Operation operation;
  private GridDataset dataset;
  
  public static WcsRequestFactory newWcsRequestFactory( String versionString,
                                                        Request.Operation operation,
                                                        GridDataset dataset )
  {
    return new WcsRequestFactory( versionString, operation, dataset);
  }

  private WcsRequestFactory( String versionString,
                             Request.Operation operation,
                             GridDataset dataset )
  {
    if ( versionString == null ) throw new IllegalArgumentException( "Version may not be null.");
    if ( operation == null ) throw new IllegalArgumentException( "Operation may not be null.");
    if ( dataset == null ) throw new IllegalArgumentException( "Dataset may not be null.");
    
    this.versionString = versionString;
    this.operation = operation;
    this.dataset = dataset;
  }

  public Request getRequest()
  {
    return request;
  }
}