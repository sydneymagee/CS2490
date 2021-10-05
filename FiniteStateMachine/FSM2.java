import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class FSM2 {
    private final static int[][] STATE_TABLE = {
        { 1, 2, 3, 4 },
        { 1, 3, 2, 4 },
        { 3, 2, 1, 4 },
        { 2, 1, 3, 4 },
        { 4, 4, 4, 4 },
    };

    private BufferedReader in;

    public FSM2() {
        in = new BufferedReader(
                 new InputStreamReader(System.in));
    }

    public void run() throws IOException {
        char ch;
        int  state;
        for (;;) {
            System.out.print("Enter your string: ");
            ch    = (char) in.read();

            // set state to start state
            state = 0;   
                   
            while (ch != '\n') {
               state = STATE_TABLE[state][charToColumn(ch)];
               ch    = (char) in.read();
            }

            // determine whether to accept or reject
            if (state == 1){ 
                System.out.println("1\n");
            } 
            else if (state == 2){
		        System.out.println("5\n");
	        }   
            else if (state == 3){
                System.out.println("8\n");
            }
            else{
                System.out.println("TRAP\n");
            }
        }
    }
    public int charToColumn(char ch) {
        // column 2 is for some unexpected character
        int column = 3;

        switch( ch ) {
        case '1':
            column = 0;
            break;

        case '5':
            column = 1;
            break;
        
        case '8':
            column = 2;
            break;
        
        }

        return column;
    }

    public static void main(String[] args) {
        try {
            FSM2 fsm = new FSM2();
            fsm.run();
        } catch (IOException ex) {
            ex.printStackTrace();
            System.exit(1);
        }
    }
}
