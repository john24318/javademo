package com.oreilly.tiger.ch03;

public enum GuitarFeatures implements Features {

	ROSEWOOD(0), // back/sides
	MAHOGANY(0), // back/sides
	ZIRICOTE(300), // back/sides

	SPRUCE(0), // top
	CEDAR(0), // top

	AB_ROSETTE(75), // abalone rosette
	AB_TOP_BORDER(400), // abalone top border

	IL_DIAMONDS(150), // diamond/square inlay
	IL_DOTS(0); // dots inlays

	/** The upcharge for the feature */
	private float upcharge;

	GuitarFeatures(float upcharge) {
		this.upcharge = upcharge;
	}

	public float getUpcharge() {
		return upcharge;
	}

	public String getDescription() {
		switch (this) {
		case ROSEWOOD:
			return "Rosewood back and sides";
		case MAHOGANY:
			return "Mahogany back and sides";
		case ZIRICOTE:
			return "Ziricote back and sides";
		case SPRUCE:
			return "Sitka Spruce top";
		case CEDAR:
			return "Wester Red Cedar top";
		case AB_ROSETTE:
			return "Abalone rosette";
		case AB_TOP_BORDER:
			return "Abalone top border";
		case IL_DIAMONDS:
			return "Diamonds and squares fretboard inlay";
		case IL_DOTS:
			return "Small dots fretboard inlay";
		default:
			return "Unknown feature";
		}
	}
}