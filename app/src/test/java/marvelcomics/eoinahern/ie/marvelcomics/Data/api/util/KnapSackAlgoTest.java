package marvelcomics.eoinahern.ie.marvelcomics.Data.api.util;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class KnapSackAlgoTest {

	private KnapSackAlgo knapSackAlgo;
	private int[] weights;
	private int[] pages;

	@Before
	public void setUp() throws Exception {
		knapSackAlgo = new KnapSackAlgo();
	}

	@Test
	public void calcMaxNumPages() throws Exception {

		weights = new int[]{4, 7, 9, 6, 2};
		pages = new int[]{20, 40, 90, 100, 30};

		int result = knapSackAlgo.knapSack(pages, weights, 12, 0);
		System.out.println("most pages " + String.valueOf(result));
		Assert.assertEquals(150, result);

		weights = new int[]{ 8, 7, 9, 16, 2};
		pages = new int[]{  100, 10, 70, 100, 100};

		result = knapSackAlgo.knapSack(pages, weights, 10, 0);
		System.out.println("most pages " + String.valueOf(result));
		Assert.assertEquals(200, result);


		weights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 195, 225, 225, 250, 399, 399, 399, 399, 399,
				399, 399, 399, 399, 399, 399, 399, 399, 399, 399, 498, 498, 498, 498, 498, 498,
				599, 999, 1699, 2499, 2499, 2499, 3999 };

		pages = new int[] { 36, 36, 32, 36, 52, 36, 36, 36, 36, 36, 36, 8, 36, 36, 36, 36, 32, 32,
				32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 40, 32, 40, 40, 48, 40, 40,
				40, 72, 144, 144, 136, 192, 208, 320 };

		result = knapSackAlgo.knapSack(pages, weights, 4933, 0);
		System.out.println("most pages " + String.valueOf(result));

	}

}