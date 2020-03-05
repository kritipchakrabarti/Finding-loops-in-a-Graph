public class Remove_xtra
{
    int[][] rem(int a[][])
    {
        // If nothing comes in, the ones from which arrow goes out must be removed

        int c=0;
        for(int i=0;i<5;i++)
        {
            for(int j=0;j<5;j++)
            {
                if(a[j][i]==0)
                {
                    c++;
                }
            }

            if(c==100)
            {
                for(int k=0;k<100;k++)
                {
                    a[i][k]=0;
                }
            }
            c=0;
        }
        return a;
    }
}
