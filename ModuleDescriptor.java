public class ModuleDescriptor {

	private String code;

	private String name;

	private double[] CAWeights;

	public ModuleDescriptor(String code, String name, double[] CAWeights) {

		// Validates parameters
		if (code == null) {
			throw new IllegalArgumentException("Code cannot be null");
		} else if (name == "") {
			throw new IllegalArgumentException("Name cannot be null");
		} else if (CAWeights == null || CAWeights.length == 0) {
			throw new IllegalArgumentException("Weights cannot be null");
		} else {
			this.code = code;
			this.name = name;
			this.CAWeights = CAWeights;
		}

		// Calculates total weighting of controlled assessment
		double weight_sum = 0.0;
		for (double weight : CAWeights) {
			if (weight <= 0) {
				throw new IllegalArgumentException("Weights cannot be less than 0");
			} else {
				weight_sum += weight;
			}
		}
		if (weight_sum != 1) {
			throw new IllegalArgumentException("Weights need to add to 1");
		}
	}
	
	public String getModuleCode(){
		return code;
	}
}
