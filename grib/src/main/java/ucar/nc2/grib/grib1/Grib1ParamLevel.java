/*
 * Copyright (c) 1998 - 2011. University Corporation for Atmospheric Research/Unidata
 * Portions of this software were developed by the Unidata Program at the
 * University Corporation for Atmospheric Research.
 *
 * Access and use of this software shall impose the following obligations
 * and understandings on the user. The user is granted the right, without
 * any fee or cost, to use, copy, modify, alter, enhance and distribute
 * this software, and any derivative works thereof, and its supporting
 * documentation for any purpose whatsoever, provided that this entire
 * notice appears in all copies of the software, derivative works and
 * supporting documentation.  Further, UCAR requests that the user credit
 * UCAR/Unidata in any publications that result from the use of this
 * software or in any product that includes this software. The names UCAR
 * and/or Unidata, however, may not be used in any advertising or publicity
 * to endorse or promote any products or commercial entity unless specific
 * written permission is obtained from UCAR/Unidata. The user also
 * understands that UCAR/Unidata is not obligated to provide the user with
 * any support, consulting, training or assistance of any kind with regard
 * to the use, operation and performance of this software nor to provide
 * the user with any updates, revisions, new versions or "bug fixes."
 *
 * THIS SOFTWARE IS PROVIDED BY UCAR/UNIDATA "AS IS" AND ANY EXPRESS OR
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL UCAR/UNIDATA BE LIABLE FOR ANY SPECIAL,
 * INDIRECT OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES WHATSOEVER RESULTING
 * FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN ACTION OF CONTRACT,
 * NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF OR IN CONNECTION
 * WITH THE ACCESS, USE OR PERFORMANCE OF THIS SOFTWARE.
 */

package ucar.nc2.grib.grib1;

import net.jcip.annotations.Immutable;
import ucar.nc2.grib.GribNumbers;
import ucar.nc2.grib.VertCoord;

/**
 * Process level information from GRIB-1 Table 3: "TYPE AND VALUE OF LEVEL"
 * Performs operations related to loading level information from Table 3.
 * @author Capt Richard D. Gonzalez, rkambic, caron
 */
@Immutable
public class Grib1ParamLevel {

  /**
   * type of vertical coordinate: Description or short Name
   * derived from  ON388 - TABLE 3.
   *
   * @param levelType table 3 code
   * @return level description
   */
  static public String getLevelDescription(int levelType) {

    switch (levelType) {

      case 0:
        return "Reserved";

      case 1:
        return "Ground or water surface";

      case 2:
        return "Cloud base level";

      case 3:
        return "Level of cloud tops";

      case 4:
        return "Level of 0deg C isotherm";

      case 5:
        return "Level of adiabatic condensation lifted from the surface";

      case 6:
        return "Maximum wind level";

      case 7:
        return "Tropopause";

      case 8:
        return "Nominal top of the atmosphere";

      case 9:
        return "Sea bottom";

      case 20:
        return "Isothermal level";

      case 100:
        return "Isobaric surface";

      case 101:
        return "Layer between 2 isobaric levels";

      case 102:
        return "Mean sea level";

      case 103:
        return "Altitude above mean sea level";

      case 104:
        return "Layer between 2 altitudes above msl";

      case 105:
        return "Specified height level above ground";

      case 106:
        return "Layer between 2 specified height level above ground";

      case 107:
        return "Sigma level";

      case 108:
        return "Layer between 2 sigma levels";

      case 109:
        return "Hybrid level";

      case 110:
        return "Layer between 2 hybrid levels";

      case 111:
        return "Depth below land surface";

      case 112:
        return "Layer between 2 depths below land surface";

      case 113:
        return "Isentropic theta level";

      case 114:
        return "Layer between 2 isentropic levels";

      case 115:
        return "Level at specified pressure difference from ground to level";

      case 116:
        return "Layer between 2 level at pressure difference from ground to level";

      case 117:
        return "Potential vorticity surface";

      case 119:
        return "Eta level";

      case 120:
        return "Layer between 2 Eta levels";

      case 121:
        return "Layer between 2 isobaric levels";

      case 125:
        return "Specified height level above ground";

      case 126:
        return "Isobaric level";  // LOOK: NCEP specific ? not in manual on codes

      case 128:
        return "Layer between 2 sigma levels (hi precision)";

      case 141:
        return "Layer between 2 isobaric surfaces";  // LOOK

      case 160:
        return "Depth below sea level";

      case 200:
        return "Entire atmosphere";

      case 201:
        return "Entire ocean";

      // LOOK NCEP specific
      case 204:
        return "Highest tropospheric freezing level";

      case 206:
        return "Grid scale cloud bottom level";

      case 207:
        return "Grid scale cloud top level";

      case 209:
        return "Boundary layer cloud bottom level";

      case 210: // manual has: Isobaric surface (high precision) Pressure in Pa (2 octets)
        return "Boundary layer cloud top level";

      case 211:
        return "Boundary layer cloud layer";

      case 212:
        return "Low cloud bottom level";

      case 213:
        return "Low cloud top level";

      case 214:
        return "Low Cloud Layer";

      case 222:
        return "Middle cloud bottom level";

      case 223:
        return "Middle cloud top level";

      case 224:
        return "Middle Cloud Layer";

      case 232:
        return "High cloud bottom level";

      case 233:
        return "High cloud top level";

      case 234:
        return "High Cloud Layer";

      case 242:
        return "Convective cloud bottom level";

      case 243:
        return "Convective cloud top level";

      case 244:
        return "Convective cloud layer";

      case 245:
        return "Lowest level of the wet bulb zero";

      case 246:
        return "Maximum equivalent potential temperature level";

      case 247:
        return "Equilibrium level";

      case 248:
        return "Shallow convective cloud bottom level";

      case 249:
        return "Shallow convective cloud top level";

      case 251:
        return "Deep convective cloud bottom level";

      case 252:
        return "Deep convective cloud top level";

      case 255:
        return "Missing";

      default:
        return "Unknown=" + levelType;
    }

  }

  /**
   * short name of level.
   *
   * @param levelType table 3 code
   * @return short name of level, for use in variable names
   */
  static public String getNameShort(int levelType) {

    switch (levelType) {

      case 1:
        return "surface";

      case 2:
        return "cloud_base";

      case 3:
        return "cloud_tops";

      case 4:
        return "zeroDegC_isotherm";

      case 5:
        return "adiabatic_condensation_lifted";

      case 6:
        return "maximum_wind";

      case 7:
        return "tropopause";

      case 8:
        return "atmosphere_top";

      case 9:
        return "sea_bottom";

      case 20:
        return "isotherm";

      case 100:
        return "isobaric";

      case 101:
        return "layer_between_two_isobaric";

      case 102:
        return "msl";

      case 103:
        return "altitude_above_msl";

      case 104:
        return "layer_between_two_altitudes_above_msl";

      case 105:
        return "height_above_ground";

      case 106:
        return "layer_between_two_heights_above_ground";

      case 107:
        return "sigma";

      case 108:
        return "layer_between_two_sigmas";

      case 109:
        return "hybrid";

      case 110:
        return "layer_between_two_hybrids";

      case 111:
        return "depth_below_surface";

      case 112:
        return "layer_between_two_depths_below_surface";

      case 113:
        return "isentrope";

      case 114:
        return "layer_between_two_isentrope";

      case 115:
        return "pressure_difference";

      case 116:
        return "layer_between_two_pressure_difference_from_ground";

      case 117:
        return "potential_vorticity_surface";

      case 119:
        return "eta";

      case 120:
        return "layer_between_two_eta";

      case 121:
        return "layer_between_two_isobaric_surfaces";

      case 125:
        return "height_above_ground";

      case 126:
        return "isobaric";

      case 128:
        return "layer_between_two_sigmas_hi";

      case 141:
        return "layer_between_two_isobaric_surfaces";

      case 160:
        return "depth_below_sea";

      case 200:
        return "entire_atmosphere";

      case 201:
        return "entire_ocean";

      // LOOK NCEP specific
      case 204:
        return "highest_tropospheric_freezing";

      case 206:
        return "grid_scale_cloud bottom";

      case 207:
        return "grid_scale_cloud_top";

      case 209:
        return "boundary_layer_cloud_bottom";

      case 210:
        return "boundary_layer_cloud_top";

      case 211:
        return "boundary_layer_cloud_layer";

      case 212:
        return "low_cloud_bottom";

      case 213:
        return "low_cloud_top";

      case 214:
        return "low_cloud_layer";

      case 222:
        return "middle_cloud_bottom";

      case 223:
        return "middle_cloud_top";

      case 224:
        return "middle_cloud_layer";

      case 232:
        return "high_cloud_bottom";

      case 233:
        return "high_cloud_top";

      case 234:
        return "high_cloud_layer";

      case 242:
        return "convective_cloud_bottom";

      case 243:
        return "convective_cloud_top";

      case 244:
        return "convective_cloud_layer";

      case 245:
        return "lowest_level_of_wet_bulb_zero";

      case 246:
        return "maximum_equivalent_potential_temperature";

      case 247:
        return "equilibrium";

      case 248:
        return "shallow_convective_cloud_bottom";

      case 249:
        return "shallow_convective_cloud_top";

      case 251:
        return "deep_convective_cloud_bottom";

      case 252:
        return "deep_convective_cloud_top";

      case 255:
        return "";

      default:
        return "Unknown" + levelType;
    }

  }  // end getNameShort

  /**
   * type of vertical coordinate: units
   * derived from  ON388 - TABLE 3.
   *
   * @param levelType table 3 code
   * @return unit as String
   */
  static public String getUnits(int levelType) {

    switch (levelType) {

      case 20:
      case 113:
      case 114:
        return "K";

      case 100:
      case 101:
      case 115:
      case 116:
      case 121:
      case 141:
        return "hPa";

      case 103:
      case 104:
      case 105:
      case 106:
      case 160:
        return "m";

      case 107:
      case 108:
      case 128:
        return "sigma";

      case 111:
      case 112:
      case 125:
        return "cm";

      case 117:
        return "10-6Km2/kgs";

      case 126:
        return "Pa";
    }
    return "";
  }

 /**
   * is this a VerticalCoordinate.
   *
   * @param levelType table 3 code
   * @return isVerticalCoordinate
   */
  public static boolean isVerticalCoordinate(int levelType) {

    if (levelType == 20) {
      return true;
    }
    if (levelType == 100) {
      return true;
    }
    if (levelType == 101) {
      return true;
    }
    if ((levelType >= 103) && (levelType <= 128)) {
      return true;
    }
    if (levelType == 141) {
      return true;
    }
    if (levelType == 160) {
      return true;
    }
    return false;
  }

  static public String getDatum(int levelType) {

     switch (levelType) {

       case 103:
         return "mean sea level";

       case 105:
       case 106:
       case 111:
       case 112:
       case 115:
       case 116:
       case 125:
         return "ground";

       case 160:
         return "sea level";


       default:
         return null;
     }
  }



  /**
   * is this a PositiveUp VerticalCoordinate.
   *
   * @param levelType table 3 code
   * @return isPositiveUp
   */
  public static boolean isPositiveUp(int levelType) {

    if (levelType == 103) {
      return true;
    }
    if (levelType == 104) {
      return true;
    }
    if (levelType == 105) {
      return true;
    }
    if (levelType == 106) {
      return true;
    }
    if (levelType == 111) {
      return true;
    }
    if (levelType == 112) {
      return true;
    }
    if (levelType == 125) {
      return true;
    }
    return false;
  }

  /**
   * Check to see if this grid is a layer variable
   *
   * @param levelType table 3 code
   * @return true if a layer
   */
  public static boolean isLayer(int levelType) {
    if (levelType == 101) return true;
    if (levelType == 104) return true;
    if (levelType == 106) return true;
    if (levelType == 108) return true;
    if (levelType == 110) return true;
    if (levelType == 112) return true;
    if (levelType == 114) return true;
    if (levelType == 116) return true;
    if (levelType == 120) return true;
    if (levelType == 121) return true;
    if (levelType == 128) return true;
    if (levelType == 141) return true;
    return false;
  }

   /**
   * Unit of vertical coordinate.
   * from Grib2 code table 4.5.
   * LOOK need scientific vetting, need center specific override - move to GribTables ?
   *
   * @param code code from table 4.5
   * @return level unit, default is empty unit string
   */
  static public VertCoord.VertUnit getLevelUnit(int code) {
    //     public VertUnit(int code, String units, String datum, boolean isPositiveUp)
    return new VertCoord.VertUnit(code, getUnits(code), getDatum(code), isPositiveUp(code));
  }

  //////////////////////////////////////////////////////////////////////////////////////////////

  private final int center, subcenter; // in case of center specific processing
  private final int levelType; // code Table 3 (octet 10)
  private final float value1;
  private final float value2;

  /**
   * Implements tables 3 and 3a.
   *
   * @param pds the Grib1SectionProductDefinition
   */
  public Grib1ParamLevel(Grib1SectionProductDefinition pds) {

    // default surface values
    center = pds.getCenter();
    subcenter = pds.getSubCenter();
    levelType = pds.getLevelType();
    int pds11 = pds.getLevelValue1();
    int pds12 = pds.getLevelValue2();
    int pds1112 = pds11 << 8 | pds12;

    switch (levelType) {
      default:
        value1 = pds11;
        value2 = pds12;
        break;

      case 20:
        value1 = (float) (pds1112 * 0.01);
        value2 = GribNumbers.MISSING;
        break;

      case 100:
        value1 = pds1112;
        value2 = GribNumbers.MISSING;
        break;

      case 101:
        value1 = pds11 * 10;  // convert from kPa to hPa - who uses kPa???
        value2 = pds12 * 10;
        break;

      case 103:
        value1 = pds1112;
        value2 = GribNumbers.MISSING;
        break;

      case 104:
        value1 = (pds11 * 100);  // convert hm to m
        value2 = (pds12 * 100);
        break;

      case 105:
        value1 = pds1112;
        value2 = GribNumbers.MISSING;
        break;

      case 106:
        value1 = (pds11 * 100);  // convert hm to m
        value2 = (pds12 * 100);
        break;

      case 107:
        value1 = (float) (pds1112 * 0.0001);
        value2 = GribNumbers.MISSING;
        break;

      case 108:
        value1 = (float) (pds11 * 0.01);
        value2 = (float) (pds12 * 0.01);
        break;

      case 109:
        value1 = pds1112;
        value2 = GribNumbers.MISSING;
        break;

      case 110:
        value1 = pds11;
        value2 = pds12;
        break;

      case 111:
        value1 = pds1112;
        value2 = GribNumbers.MISSING;
        break;

      case 112:
        value1 = pds11;
        value2 = pds12;
        break;

      case 113:
        value1 = pds1112;
        value2 = GribNumbers.MISSING;
        break;

      case 114:
        value1 = 475 - pds11;
        value2 = 475 - pds12;
        break;

      case 115:
        value1 = pds1112;
        value2 = GribNumbers.MISSING;
        break;

      case 116:
        value1 = pds11;
        value2 = pds12;
        break;

      case 117:
        value1 = pds1112;
        value2 = GribNumbers.MISSING;
        break;

      case 119:
        value1 = (float) (pds1112 * 0.0001);
        value2 = GribNumbers.MISSING;
        break;

      case 120:
        value1 = (float) (pds11 * 0.01);
        value2 = (float) (pds12 * 0.01);
        break;

      case 121:
        value1 = 1100 - pds11;
        value2 = 1100 - pds12;
        break;

      case 125:
        value1 = pds1112;
        value2 = GribNumbers.MISSING;
       break;

      case 126:
        value1 = pds1112;
        value2 = GribNumbers.MISSING;
        break;

      case 128:
        value1 = (float) (1.1 - (pds11 * 0.001));
        value2 = (float) (1.1 - (pds12 * 0.001));
        break;

      case 141:
        //value1 = pds11*10; // convert from kPa to hPa - who uses kPa???
        value1 = pds11;  // 388 nows says it is hPA
        value2 = 1100 - pds12;
        break;

      case 160:
        value1 = pds1112;
        value2 = GribNumbers.MISSING;
        break;

      // LOOK NCEP specific

      case 236:
        value1 = pds11;
        value2 = pds12;
        break;
    }
  }

  /**
   * Index number from table 3 (pds octet 10)
   *
   * @return index
   */
  public int getLevelType() {
    return levelType;
  }

  /**
   * gets the 1st value for the level.
   *
   * @return level value 1
   */
  public float getValue1() {
    return value1;
  }

  /**
   * gets the 2nd value for the level.
   *
   * @return level value 2
   */
  public float getValue2() {
    return value2;
  }

  public boolean isLayer() {
    return isLayer(levelType);
  }

  public boolean isPositiveUp() {
    return isPositiveUp(levelType);
  }

  public String getUnits() {
    return getUnits(levelType);
  }

}

