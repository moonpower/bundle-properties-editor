package net.moon.util.bundlePropertiesEditor;

public class FlagSupport {

	private int flags;

	public FlagSupport(int flags) {
		super();
		this.flags = flags;
	}

	public int getFlags() {
		return this.flags;
	}

	public boolean isTrue(int flag) {
		return (this.flags & flag) != 0;
	}

	public void set(int flag, boolean value) {
		if (value) {
			this.flags |= flag;
		}
		else {
			this.flags &= ~flag;
		}
	}

}
