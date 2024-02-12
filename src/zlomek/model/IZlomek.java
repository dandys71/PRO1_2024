package zlomek.model;

public interface IZlomek {
    IZlomek vynasob(IZlomek z);

    IZlomek vydel(IZlomek z);

    IZlomek secti(IZlomek z);

    IZlomek odecti(IZlomek z);

    int getCitatel();

    int getJmenovatel();

}
