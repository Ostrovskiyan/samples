package com.aostrovskyi.samples.patterns.bridge;

public class RasterRenderer implements Renderer {

    @Override
    public String whatToRenderAs() {
        return "pixels";
    }
}
