package com.imagelab.operators;

import lombok.Getter;
import lombok.Setter;
import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;

import java.util.HashSet;
import java.util.Set;

public class ReadImage extends OpenCVOperator {

    @Getter
    @Setter
    private String url = "imageFile/main/resources/com/imagelab/images/scorelabLogo.jpg";

    @Override
    public boolean validate(OpenCVOperator previous) {
        return true;
        // return allowedOperators().contains(previous.getClass());
    }

    @Override
    public Mat compute(Mat image) {
        // image: null
        System.out.println("reading image");
        return readImage();
    }

    @Override
    public Set<Class<?>> allowedOperators() {
        Set<Class<?>> allowed = new HashSet<>();
        allowed.add(ReadImage.class);
        return allowed;
    }

    public Mat readImage() {
        String filePath = url;
        return Highgui.imread(filePath);
    }

}