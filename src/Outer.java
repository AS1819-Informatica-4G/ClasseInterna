public class Outer {
	private String aaa;
	public class Inner {
		private int ugo;
		void setUgo(int u) {
			ugo=u;
		}
		int getUgo() {
			System.out.println("Sono getUgo nella Inner");
			System.out.println(aaa);
			return ugo;
		}
	}
    static class Internal {
    	public int uno;

		public int getUno() {
			return uno;
		}

		public void setUno(int uno) {
			this.uno = uno;
		}
    	
    }
	public Outer() {
		aaa="Cicocico";	
		Inner in=new Inner();
		in.setUgo(7);
		System.out.println("Sono il costruttore di Outer e chiamo Inner="+in.getUgo());
	}
	
	public void innesto() {
		int valore=0;
		class Interna {
			private int gedeone=13;
			public void printGedeone() {
				System.out.println("Sono Interna dentro innesto");
				System.out.println("Gedeone="+gedeone);
				gedeone=valore;
				System.out.println("aaa vale="+Outer.this.aaa);
				// valore++; //--> Non possibile
			}
		}
		
		Interna inner=new Interna();
		inner.printGedeone();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Outer ou=new Outer();
		Outer.Inner in=ou.new Inner();
		in.setUgo(12);
		System.out.println(""+in.getUgo());
		ou.innesto();
		
		Internal instestinal=new Internal(); // Se dichiarata statica diventa top class!!
		
		// Creazione classe anonima da Classe base
		Anonima anon=new Anonima() {
			@Override
			public void metodo() {
				System.out.println("Ecco il metodo riscritto nella classe senza nome");
				metodoNonUsabile(); // Richiamabile solo da qui!!
			}
			public void metodoNonUsabile() {
				System.out.println("Non utilizzabile da fuori");
			}
		};
		
	    anon.metodo();
	    
	    // Creazione classe anonima da interfaccia
	    Volante ufo=new Volante() {
	    	@Override
	    	public void plana() {
	    		System.out.println("un oggetto volante non identificato plana");
	    	}
	    	@Override
	    	public void decolla() {
	    		System.out.println("un oggetto volante non identificato decolla");
	    	}
	    	@Override
	    	public void atterra() {
	    		System.out.println("un oggetto volante non identificato atterra");
	    	}
 	    };
	}

}
