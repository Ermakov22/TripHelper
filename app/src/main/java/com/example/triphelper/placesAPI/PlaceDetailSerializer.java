package com.example.triphelper.placesAPI;

import com.google.gson.annotations.SerializedName;

import java.util.List;

class PlaceDetailSerializer {
    public class Geometry {
        public class Location {
            Double lat;
            Double lng;
        }
        Location location;
    }

    public class AddressComponent {
        String long_name;
        String short_name;
        String[] types;
    }

    public class Photo {
        int height;
        int width;
        String photo_reference;
    }

    public class Place {
        @SerializedName("place_id")
        private String place_id;

        @SerializedName("name")
        private String name;

        @SerializedName("address_components")
        private List<AddressComponent> address_components;

        @SerializedName("formatted_address")
        private String formatted_address;

        @SerializedName("international_phone_number")
        private String phone_number;

        @SerializedName("photos")
        private List<Photo> photos;

        @SerializedName("geometry")
        private Geometry geometry;

        @SerializedName("icon")
        private String icon;

        @SerializedName("rating")
        Double rating;

        @SerializedName("types")
        private String[] types;

        @SerializedName("url")
        private String url;

        @SerializedName("vicinity")
        private String vicinity;

        @SerializedName("website")
        private String website;

        public String getID() {
            return place_id;
        }

        public String getName() {
            return name;
        }

        public String getAddress() {
            return formatted_address;
        }

        public List<Photo> getPhotos() {
            return photos;
        }

        public String getPhotoURL(int maxwidth) {
            if (photos != null && !photos.isEmpty()) {
                String key = PlaceAutocompleteAPI.KEY;
                Photo photo = photos.get(0);
                String ref = photo.photo_reference;
                String url = String.format("https://maps.googleapis.com/maps/api/place/photo?maxwidth=%d&photoreference=%s&key=%s",
                        maxwidth, ref, key);
                return url;
            }
            return null;
        }

        @Override
        public String toString() {
            return "Place{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    @SerializedName("result")
    private Place result;

    @SerializedName("status")
    private String status;


    public Place getPlace() {
        return result;
    }
}
