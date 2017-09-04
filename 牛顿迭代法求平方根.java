class Solution {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
	public int sqrt(int x) {
		// write your code here
		//牛顿迭代法
		double c = x;
		int res;
		if (c < 0) {
			res = (int) Double.NaN;
		} else {
			double err = 1e-15;
			double t = c;
			while (Math.abs(t - c / t) > err * t) {
				t = (c / t + t) / 2.0;
			}
			res = (int) t;
		}
		return res;
	}
}