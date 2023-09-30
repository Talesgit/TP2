import java.util.Scanner;
class pBin{

	static int[] vec = new int[9999999];
        static void quicksort(int esq, int dir) {
  	int i = esq, j = dir, pivo = vec[(esq+dir)/2];
	while (i <= j) {
	while (vec[i] < pivo)
	i++;
	while (vec[j] > pivo)
	j--;
	if (i <= j)
	{
	//SWAP
        int temp = vec[i];
	vec[i] = vec[j];
        vec[j] = temp; 
	i++;
	j--; }
	}
	if (esq < j)
	quicksort(esq, j);
	if (i < dir)
	quicksort(i, dir);
	}

	public static void main(String args[]){
		//int[] vec = new int[99999999];
		Scanner s = new Scanner(System.in);
		int n = vec.length;

		int c = 0;
		for(int p = vec.length-1; p >= 0; p--){
			vec[c] = p;
			c++;
		}
/*
		for(int i = 0; i < n-1; i++){
			int menor = i;
			for(int j = i + 1; j < n; j++){
				if(vec[menor] > vec[j]){
					menor = j;
				}
	                 }
				//SWAP
				int temp = vec[menor];
				vec[menor] = vec[i];
				vec[i] = temp;	
		}
*/		
		quicksort(0, n-1);
		System.out.println("Array ordenado: ");
		for(int k = 0; k < vec.length; k++){
			System.out.println(vec[k]);
		}

		int x = 0;
		do{

		System.out.println("Valor a procurar no array: ");
		x = s.nextInt();
                                
		 
        
                               boolean resp = false;
			       int dir = n - 1, esq = 0, meio;
				while (esq <= dir) {
					meio = (esq + dir) / 2;
					if (x == vec[meio]){
					resp = true;
					esq = n;
					} else if (x > vec[meio]){
						esq = meio + 1;
					} else {
						dir = meio - 1;
					}
				}
		                 
		                if(resp){
                                       System.out.println(resp);
                               }else{
                                       System.out.println("Valor nao achado");
                               }
		}while(x != -1);

		

	    }
	}

