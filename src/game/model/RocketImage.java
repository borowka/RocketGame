package game.model;


import javafx.scene.image.ImageView;

public enum RocketImage {

    INSTANCE;
    ImageView imageView;

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }
}
