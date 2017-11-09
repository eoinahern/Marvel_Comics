package marvelcomics.eoinahern.ie.marvelcomics.Domain.MainGallery;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.observers.TestObserver;
import marvelcomics.eoinahern.ie.marvelcomics.Data.api.api.MarvelService;
import marvelcomics.eoinahern.ie.marvelcomics.Data.api.models.Comic;
import marvelcomics.eoinahern.ie.marvelcomics.Data.api.models.ComicContainer;
import marvelcomics.eoinahern.ie.marvelcomics.Data.api.models.ComicWrapper;
import marvelcomics.eoinahern.ie.marvelcomics.Domain.models.DomainComic;
import marvelcomics.eoinahern.ie.marvelcomics.Domain.models.mapper.ComicMapper;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class GetMainGalleryInteractorTest {

	@Mock List<Comic> mockComicList;
	@Mock List<DomainComic> mockDomainComicList;
	@Mock ComicWrapper mockComicWrapper;
	@Mock ComicContainer mockComicContainer;
	@Mock MarvelService mockMarvelService;
	@Mock ComicMapper mockComicMapper;


	@InjectMocks
	private GetMainGalleryInteractor getMainGalleryInteractor;

	@Before
	public void setUp() throws Exception {


		Mockito.doReturn(Observable.just(mockComicWrapper))
				.when(mockMarvelService)
				.getComics();

		when(mockComicWrapper.data()).thenReturn(mockComicContainer);
		when(mockComicContainer.results()).thenReturn(mockComicList);
		when(mockComicMapper.mapList(mockComicList)).thenReturn(mockDomainComicList);
		when(mockDomainComicList.size()).thenReturn(2);
	}

	@Test
	public void testBuildObs() {

		List<DomainComic> te = getMainGalleryInteractor.buildObservable().blockingFirst();

		Assert.assertEquals(te.size(), 2);

		verify(mockMarvelService).getComics();
		verify(mockComicWrapper).data();
		verify(mockComicContainer).results();
		verify(mockComicMapper).mapList(mockComicList);
	}
}