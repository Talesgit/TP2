class Ins{
	public static void main(String[] args){
		int[] array = new int[20];
		int k = 0;
		for(int i = 19; i >= 0 ; i--){
			array[k] = i;
			k++;
		}


		// insercao
		for(int i = 1; i < array.length; i++){ // na insercao, i comeca com 1, pois a primeira pos ja esta ordenada
			int j = i - 1; // j servira para ser uma pos anterior afim de comparar se a atual(i) é < que a anterior
			int temp = array[i]; 
				while(j >= 0 && temp < array[j]){ // caso a atual seja menor que anterior
					array[j+1] = array[j]; // a atual recebe a anterior
					j--; // decrementa a "atual" de dentro do while, para ir a pos da frente ir recebendo a atual ate que a pos do j nao seja menor que a temp
				}
				array[j+1] = temp; // j mais um pois ele tera decrementado na ultima verificacao
		}


		for(int i = 0; i < array.length; i++){
			MyIO.println(array[i]);
		}
	}
}
