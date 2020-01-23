class ImprimeTriangulos{
	public static void main(String[] args){
		int i, j, k;
		for (k = 0; k < 2; k++){
			for(i = 0; i < 6; i++){
				for(j = 0; j <= i; j++){
					System.out.print("*");
				}
				System.out.println("");
				j = 0;
			}
			i = 0;
		}
	}
}