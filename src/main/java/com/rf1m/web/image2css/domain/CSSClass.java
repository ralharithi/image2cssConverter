package com.rf1m.web.image2css.domain;

public class CSSClass {
    protected final String name;
    protected final String body;

    public CSSClass(String name, String body) {
        this.name = name;
        this.body = body;
    }

    public String getName() {
		return name;
	}

	public String getBody() {
		return body;
	}
}
