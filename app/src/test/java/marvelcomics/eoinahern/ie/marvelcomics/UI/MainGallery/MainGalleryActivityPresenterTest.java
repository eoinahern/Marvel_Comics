package marvelcomics.eoinahern.ie.marvelcomics.UI.MainGallery;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.observers.TestObserver;
import io.reactivex.subscribers.TestSubscriber;
import marvelcomics.eoinahern.ie.marvelcomics.Data.api.api.MarvelService;
import marvelcomics.eoinahern.ie.marvelcomics.Domain.BaseDisposableObserver;
import marvelcomics.eoinahern.ie.marvelcomics.Domain.MainGallery.GetMainGalleryInteractor;
import marvelcomics.eoinahern.ie.marvelcomics.Domain.models.DomainComic;


@RunWith(MockitoJUnitRunner.class)
public class MainGalleryActivityPresenterTest {

	@Mock GetMainGalleryInteractor mockMainGalleryInteractor;
	@Mock MainGalleryActivityView mockView;
	@Mock List<DomainComic> mockList;

	private MainGalleryActivityPresenter presenter;

	@Before
	public void setUp() {
		presenter = new MainGalleryActivityPresenter(mockMainGalleryInteractor);
		presenter.attachView(mockView);
	}

	@Test
	public void Quicktest() {

		when(mockMainGalleryInteractor.buildObservable()).thenReturn(Observable.just(mockList));

		presenter.loadData();

		Mockito.verify(mockMainGalleryInteractor).execute(any());
		Mockito.verify(mockView).showLoading();
	}


}