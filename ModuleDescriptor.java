public class ModuleDescriptor {
	
	private String code;
	
	private String name;
	
	private double[] CAWeights;

	public ModuleDescriptor(String code, String name, double[] CAWeights) {
		
		// Calculates total weighting of controlled assesment
		double weight_sum = 0.0;
		for(double weight:CAWeights){
			if (weight <= 0){
				throw new IllegalArgumentException("Weights cannot be less than 0");
			} else {
				weight_sum += weight;
			}
		}
		
		// Validates parameters
		if (code == null){ 
		throw new IllegalArgumentException("Code cannot be null");
		} else if (name == ""){
			throw new IllegalArgumentException("Name cannot be null");
		} else if (CAWeights == ""){
			throw new IllegalArgumentException("Weights cannot be null");	
		} else if (weight_sum != 1){
			throw new IllegalArgumentException("Weights need to add to 1");
		} else {
			this.code = code;
			this.name = name;
			this.CAWeights = CAWeights;
		}
	}
}
