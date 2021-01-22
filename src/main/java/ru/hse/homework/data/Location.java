package ru.hse.homework.data;

import java.util.Objects;

public final class Location {

    private String ip;
    private String countryCode;
    private String countryName;
    private String regionCode;
    private String regionName;
    private String city;
    private String zipCode;
    private String timeZone;
    private Double latitude;
    private Double longitude;
    private Long metroCode;

    public Location(){

    }

    public Location(String ip, String countryCode, String countryName,
                    String regionCode, String regionName, String city,
                    String zipCode, String timeZone,
                    Double latitude, Double longitude, Long metroCode) {
        this.ip = ip;
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.regionCode = regionCode;
        this.regionName = regionName;
        this.city = city;
        this.zipCode = zipCode;
        this.timeZone = timeZone;
        this.latitude = latitude;
        this.longitude = longitude;
        this.metroCode = metroCode;
    }

    public String getIp() {
        return ip;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public String getRegionName() {
        return regionName;
    }

    public String getCity() {
        return city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Long getMetroCode() {
        return metroCode;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public void setMetroCode(Long metroCode) {
        this.metroCode = metroCode;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(ip, location.ip) &&
                Objects.equals(countryCode, location.countryCode) &&
                Objects.equals(countryName, location.countryName) &&
                Objects.equals(regionCode, location.regionCode) &&
                Objects.equals(regionName, location.regionName) &&
                Objects.equals(city, location.city) &&
                Objects.equals(zipCode, location.zipCode) &&
                Objects.equals(timeZone, location.timeZone) &&
                Objects.equals(latitude, location.latitude) &&
                Objects.equals(longitude, location.longitude) &&
                Objects.equals(metroCode, location.metroCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ip, countryCode, countryName, regionCode, regionName, city, zipCode, timeZone, latitude, longitude, metroCode);
    }
}
