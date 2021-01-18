package versionCompare;

public class VersionCompare {
	
	private static final String DOT = "\\.";

	public static void main(String... args) {
		if(!(args.length == 2)) {
			throw new IllegalArgumentException("2 versions must be supplied!");
		}
		
		System.out.println(compareVersions(args[0], args[1]));
	}

	// This code works by splitting the versions into arrays on the '.' character: v1Split and v2Split.
	// The length of the longest array is found: maxSplitLength.
	// The code then loops up to a maximum of maxSplitLength times.
	// On each loop, it parses the string value in each array into an int and compares the values. 
	// If the value isn't equal, it breaks the loop.
	public static int compareVersions(String version1, String version2) {
	    int comparisonResult = 0;
	    
	    String[] v1Split = version1.split(DOT);
	    String[] v2Split = version2.split(DOT);
	    int maxSplitLength = (v1Split.length >= v2Split.length) ? v1Split.length : v2Split.length;

	    for (int i = 0; i < maxSplitLength; i++){
	        int v1 = i < v1Split.length ? Integer.parseInt(v1Split[i]) : 0;
	        int v2 = i < v2Split.length ? Integer.parseInt(v2Split[i]) : 0;
	        int compare = (v1 < v2) ? -1 : ((v1 == v2) ? 0 : 1);
	        if (compare != 0) {
	        	return compare;
	        }
	    }
	    return comparisonResult;
	}
}
