import java.util.Arrays;

class Cycles_Node
{
    Cycles_Node exit[];
    int pos[];

    Cycles_Node(int n2)
    {
        pos=new int[n2];
        exit=new Cycles_Node[n2];
    }

    public static void main(String[] args)
    {

        Cycles_Node no[]=new Cycles_Node[100];

        int number_of_exit;

        //Giving name and linking the nodes
        for(int i=0;i<100;i++)
        {
            number_of_exit=(int)(Math.random()*100);
            no[i]=new Cycles_Node(number_of_exit);
            for(int k=0;k<number_of_exit;k++)
            {
                no[i].pos[k]=(int)(Math.random()*100);
                no[i].exit[k]=no[no[i].pos[k]];
            }
        }

        //Cerating the Matrix
        int mat[][]=new int[100][100];

        for(int i=0;i<100;i++)
        {
            for(int j=0;j<100;j++)
            {
                for(int k=0;k<no[i].pos.length;k++)
                {
                    if (no[i].pos[k] == j)
                        mat[i][j] = 1;
                }
            }
        }


        // Printing the matrix
        for(int i=0;i<100;i++)
        {
            for(int j=0;j<100;j++)
                System.out.print(mat[i][j]+" ");
                System.out.println();
        }


        // Removing the outgoing arrows which do not have ingoing arrow
        Remove_xtra remove_xtra=new Remove_xtra();
        int dup[][]=new int[100][100];

        dup=mat.clone(); ;
        while(!(Arrays.equals(dup,mat=remove_xtra.rem(mat))))
        {
            dup=mat.clone();
        }


        // Removing Self loops
        for(int i=0;i<100;i++)
        {
            mat[i][i]=0;
        }


        //Checking if loop exists
        System.out.println("");
        boolean flag=false;
        for(int i=0;i<100;i++)
        {
            for(int j=0;j<100;j++)
            {
                if(mat[i][j]==1 && mat[j][i]==1)
                    flag=true;
            }
        }

        if(flag)
        System.out.println("There exists a loop in a graph");
        else
        System.out.println("There is no loop in graph");
    }
}