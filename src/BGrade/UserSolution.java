package BGrade;

import java.util.ArrayDeque;
import java.util.Deque;

class UserSolution
{
    static class Quadrangle
    {
        int no, x, y, group;

        public Quadrangle(int no, int x, int y, int group)
        {
            this.no = no;
            this.x = x;
            this.y = y;
            this.group = group;
        }
    }

    static Quadrangle[][] quadrangleArr;
    static int maxLength, curGroupNo;

    public void init(int L, int N)
    {
        maxLength = L;
        quadrangleArr = new Quadrangle[N][N];
        curGroupNo = 1;
    }

    public int draw(int mID, int mRow, int mCol, int mHeight, int mWidth)
    {
        Deque<Quadrangle> posQ = new ArrayDeque<>();
        boolean isMeet = false;
        int meetGroupNum = -1;

        for (int i = mRow; i < mRow + mHeight; i++)
        {
            for (int j = mCol; j < mCol + mWidth; j++)
            {
                if(quadrangleArr[i][j] == null)
                {
                    if(!isMeet)
                    {
                        quadrangleArr[i][j] = new Quadrangle(mID, i, j, curGroupNo);
                        posQ.offer(quadrangleArr[i][j]);
                    }
                    else
                        quadrangleArr[i][j] = new Quadrangle(mID, i, j, meetGroupNum);
                }
                else
                {
                    isMeet = true;
                    meetGroupNum =  quadrangleArr[i][j].group;
                    quadrangleArr[i][j] = new Quadrangle(mID, i, j,meetGroupNum);
                }
            }
        }

        if(posQ.size() != mHeight * mWidth)
        {
            // 만난 사각형이 있음
            while (!posQ.isEmpty())
            {
                posQ.poll().group = meetGroupNum;
            }
        }

        return 0;
    }

    public int getRectCount(int mID)
    {
        return 0;
    }

    public int countGroup()
    {
        return 0;
    }

}
