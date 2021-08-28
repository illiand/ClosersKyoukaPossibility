package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Test2
{
    double[][] p = new double[20][4];
    double[] req;
    Random r = new Random();

    public static void main(String[] args)
    {
        Test2 test = new Test2();
        test.pInit();
        test.reqInit();
        test.normalize();

        test.run(10, 14);

//        for (int i = 0; i <= 250 ; i += 10)
//        {
//            test.runH(16, i);
//        }
    }

    public void reqInit()
    {
        req = new double[]{
                1, 1, 1, 1, 1,
                1, 1, 1, 1, 1,
                1, 2, 4, 6, 8,
                10, 10, 10, 10, 10
        };
    }

    public void pInit()
    {
        //11-19概率提升后 在强化buff下的概率
        //+1 0 -1 +2 +3 +4
        p[0] = new double[]{0.5, 0, 0, 0.25, 0.15, 0.1};
        p[1] = new double[]{0.53, 0, 0, 0.21, 0.16, 0.1};
        p[2] = new double[]{0.59, 0, 0, 0.18, 0.12, 0.11};
        p[3] = new double[]{0.63, 0, 0, 0.13, 0.13, 0.11};
        p[4] = new double[]{0.53, 0, 0, 0.13, 0.13, 0.11};
        p[5] = new double[]{0.72, 0, 0, 0.14, 0.07, 0.07};
        p[6] = new double[]{0.72, 0, 0, 0.08, 0.08, 0.02};
        p[7] = new double[]{0.88, 0, 0, 0.09, 0.02, 0.01};
        p[8] = new double[]{0.94, 0, 0, 0.04, 0.02, 0};
        p[9] = new double[]{0.96, 0, 0, 0.03, 0.01, 0};
        p[10] = new double[]{0.47, 0, 0.5, 0.02, 0.01, 0};
        p[11] = new double[]{0.98, 0.0, 0.0, 0.02, 0, 0};
        p[12] = new double[]{0.44, 0.45, 0.0, 0.01, 0, 0};
        p[13] = new double[]{0.044, 0.955, 0.0, 0.001, 0, 0};
        p[14] = new double[]{0.011, 0.969, 0.02, 0, 0, 0};
        p[15] = new double[]{0.0055, 0.9795, 0.015, 0, 0, 0};
        p[16] = new double[]{0.005, 0.98, 0.015, 0, 0, 0};
        p[17] = new double[]{0.0039, 0.9811, 0.015, 0, 0, 0};
        p[18] = new double[]{0.0039, 0.9811, 0.015, 0, 0, 0};
        p[19] = new double[]{0.0039, 0.9811, 0.015, 0, 0, 0};

        ////11-19概率提升后
        //+1 0 -1 +2 +3 +4
//        p[0] = new double[]{0.5, 0, 0, 0.25, 0.15, 0.1};
//        p[1] = new double[]{0.53, 0, 0, 0.21, 0.16, 0.1};
//        p[2] = new double[]{0.59, 0, 0, 0.18, 0.12, 0.11};
//        p[3] = new double[]{0.63, 0, 0, 0.13, 0.13, 0.11};
//        p[4] = new double[]{0.53, 0, 0, 0.13, 0.13, 0.11};
//        p[5] = new double[]{0.72, 0, 0, 0.14, 0.07, 0.07};
//        p[6] = new double[]{0.72, 0, 0, 0.08, 0.08, 0.02};
//        p[7] = new double[]{0.88, 0, 0, 0.09, 0.02, 0.01};
//        p[8] = new double[]{0.94, 0, 0, 0.04, 0.02, 0};
//        p[9] = new double[]{0.96, 0, 0, 0.03, 0.01, 0};
//        p[10] = new double[]{0.47, 0, 0.5, 0.02, 0.01, 0};
//        p[11] = new double[]{0.38, 0.3, 0.3, 0.02, 0, 0};
//        p[12] = new double[]{0.29, 0.55, 0.15, 0.01, 0, 0};
//        p[13] = new double[]{0.029, 0.77, 0.2, 0.001, 0, 0};
//        p[14] = new double[]{0.01, 0.97, 0.02, 0, 0, 0};
//        p[15] = new double[]{0.005, 0.98, 0.015, 0, 0, 0};
//        p[16] = new double[]{0.0045, 0.9805, 0.015, 0, 0, 0};
//        p[17] = new double[]{0.0035, 0.9815, 0.015, 0, 0, 0};
//        p[18] = new double[]{0.0035, 0.9815, 0.015, 0, 0, 0};
//        p[19] = new double[]{0.0035, 0.9815, 0.015, 0, 0, 0};

        //当前概率
        //+1 0 -1 +2 +3 +4
//        p[0] = new double[]{0.5, 0, 0, 0.25, 0.15, 0.1};
//        p[1] = new double[]{0.53, 0, 0, 0.21, 0.16, 0.1};
//        p[2] = new double[]{0.59, 0, 0, 0.18, 0.12, 0.11};
//        p[3] = new double[]{0.63, 0, 0, 0.13, 0.13, 0.11};
//        p[4] = new double[]{0.53, 0, 0, 0.13, 0.13, 0.11};
//        p[5] = new double[]{0.72, 0, 0, 0.14, 0.07, 0.07};
//        p[6] = new double[]{0.72, 0, 0, 0.08, 0.08, 0.02};
//        p[7] = new double[]{0.88, 0, 0, 0.09, 0.02, 0.01};
//        p[8] = new double[]{0.94, 0, 0, 0.04, 0.02, 0};
//        p[9] = new double[]{0.96, 0, 0, 0.03, 0.01, 0};
//        p[10] = new double[]{0.47, 0, 0.5, 0.02, 0.01, 0};
//        p[11] = new double[]{0.28, 0.4, 0.3, 0.02, 0, 0};
//        p[12] = new double[]{0.14, 0.7, 0.15, 0.01, 0, 0};
//        p[13] = new double[]{0.014, 0.785, 0.2, 0.001, 0, 0};
//        p[14] = new double[]{0.004, 0.976, 0.02, 0, 0, 0};
//        p[15] = new double[]{0.0026, 0.9824, 0.015, 0, 0, 0};
//        p[16] = new double[]{0.0026, 0.9824, 0.015, 0, 0, 0};
//        p[17] = new double[]{0.0026, 0.9824, 0.015, 0, 0, 0};
//        p[18] = new double[]{0.0026, 0.9824, 0.015, 0, 0, 0};
//        p[19] = new double[]{0.0026, 0.9824, 0.015, 0, 0, 0};
    }

    /**
     * 开了保罗后 以及过热后
     * 增加成功的概率
     * @param factor
     */
    public void pSuccessChangesWith(double factor)
    {
        pInit();

        for (int i = 0; i < p.length; i += 1)
        {
            p[i][0] *= factor;

            double newTotal = 0;

            for (int j = 0; j < p[i].length; j += 1)
            {
                newTotal += p[i][j];
            }

            for (int j = 0; j < p[i].length; j += 1)
            {
                p[i][j] /= newTotal;
            }
        }

        normalize();
    }

    /**
     * cumulative
     */
    public void normalize()
    {
        for (int i = 0; i < p.length; i += 1)
        {
            for (int j = 0; j < 6 - 1; j += 1)
            {
                if (j != 0)
                {
                    p[i][j] += p[i][j - 1];
                }
            }
        }
    }

    public int exec(int cur)
    {
        double result = r.nextDouble();

        if (result <= p[cur][0])
        {
            return cur + 1;
        }
        else if (result <= p[cur][1])
        {
            return cur;
        }
        else if (result <= p[cur][2])
        {
            return cur - 1;
        }
        else if (result <= p[cur][3])
        {
            return cur + 2;
        }
        else if (result <= p[cur][4])
        {
            return cur + 3;
        }
        else
        {
            return cur + 4;
        }
    }

    /**
     * 不用保罗的普通强化
     * @param cur
     * @param target
     */
    public void run(int cur, int target)
    {
        int count = 1000000;

        ArrayList<Integer> costs = new ArrayList<>();
        long addedCost = 0;

        for (int i = 0; i < count; i += 1)
        {
            int curCost = 0;
            int curLV = cur;

            while (curLV < target)
            {
                curCost += req[curLV];
                curLV = exec(curLV);

               // System.out.println(curLV);
            }

            addedCost += curCost;
            costs.add(curCost);
        }

        costs.sort(new Comparator<Integer>()
        {
            @Override
            public int compare(Integer integer, Integer t1)
            {
                return integer - t1;
            }
        });

        for (int i = 0; i < 10; i += 1)
        {
            System.out.println(i * 10 + "% : " + costs.get(count / 10 * i));
        }

        System.out.println("95% : " + costs.get((int)(count * 0.95)));
        System.out.println("99% : " + costs.get((int)(count * 0.99)));

        System.out.println();

        System.out.println("avg: " + addedCost / count);
    }

    /**
     * 保罗
     * @param curLV
     * @param defUses
     */
    public void runH(int curLV, int defUses)
    {
        int count = 1000000;

        ArrayList<Cost> costs = new ArrayList<>();

        for (int i = 0; i < count; i += 1)
        {
            int curBaoluoStatus = 0;
            int usedFuel = 0;
            int usedBaoluo = 1;
            int usedDianzi = 0;
            int dianziFlying = 0;

            pSuccessChangesWith(1.2);

            while (true)
            {
                //垫好了
                if (curBaoluoStatus >= 250 - defUses)
                {
                    while (exec(curLV) != curLV + 1)
                    {
                        if (curBaoluoStatus == 250)
                        {
                            pSuccessChangesWith(2.7);
                        }

                        usedFuel += req[curLV];
                        curBaoluoStatus += 1;
                    }

                    Cost cost = new Cost();
                    cost.baoluo = usedBaoluo;
                    cost.fuel = usedFuel;
                    cost.dianzi = Math.max(0, usedDianzi - dianziFlying);

                    costs.add(cost);

                    break;
                }

                //垫的过程
                int dianziLevel = 15;
                int status = exec(dianziLevel);
                usedFuel += req[dianziLevel];

                if (status == 14)
                {
                    usedDianzi += 1;
                    curBaoluoStatus += 1;
                }

                if (status == 15)
                {
                    curBaoluoStatus += 1;
                }

                if (status == 16)
                {
                    curBaoluoStatus = 0;
                    usedBaoluo += 1;
                    dianziFlying += 1;
                }
            }
        }

        costs.sort(new Comparator<Cost>()
        {
            @Override
            public int compare(Cost cost1, Cost cost2)
            {
                return cost1.fuel - cost2.fuel;
            }
        });

//        for (int i = 0; i < 10; i += 1)
//        {
//            System.out.println(i * 10 + "% : " + costs.get(count / 10 * i));
//        }
//
//        System.out.println("95% : " + costs.get((int)(count * 0.95)));
//        System.out.println("99% : " + costs.get((int)(count * 0.99)));
//
//        System.out.println();

        int totalBaoluo = 0;
        int totalDianzi = 0;
        long totalFuel = 0;

        for (int i = 0; i < count; i += 1)
        {
            totalBaoluo += costs.get(i).baoluo;
            totalDianzi += costs.get(i).dianzi;
            totalFuel += costs.get(i).fuel;
        }

        System.out.println("avg(" + defUses + "): " + "保罗 = " + totalBaoluo / (float)count + ", 垫子 = " + totalDianzi / (float)count + ", 燃料 = " + totalFuel / count);
    }

    public class Cost
    {
        public int dianzi;
        public int fuel;
        public int baoluo;

        @Override
        public String toString()
        {
            return fuel + "";
        }
    }
}
