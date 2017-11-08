package marvelcomics.eoinahern.ie.marvelcomics.UI.MainGallery;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.observers.TestObserver;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.TestSubscriber;
import marvelcomics.eoinahern.ie.marvelcomics.Data.api.api.MarvelService;
import marvelcomics.eoinahern.ie.marvelcomics.Domain.BaseDisposableObserver;
import marvelcomics.eoinahern.ie.marvelcomics.Domain.MainGallery.GetMainGalleryInteractor;
import marvelcomics.eoinahern.ie.marvelcomics.Domain.models.DomainComic;
import marvelcomics.eoinahern.ie.marvelcomics.utils.RxAnswer;


@RunWith(MockitoJUnitRunner.class)
public class MainGalleryActivityPresenterTest {

	@Mock GetMainGalleryInteractor mockMainGalleryInteractor;
	@Mock MainGalleryActivityView mockView;
	@Mock List<DomainComic> mockList;
	@Mock DomainComic dm1;
	@Mock DomainComic dm2;
	@Mock BaseDisposableObserver<List<DomainComic>> mockDisposableObserver;

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

		mockList = new ArrayList<>();
		mockList.add(dm1);
		mockList.add(dm2);

		Mockito.verify(mockMainGalleryInteractor).execute(any());
		Mockito.verify(mockView).showLoading();
	}

	@Test
	public void Quicktest2() {

		when(mockMainGalleryInteractor.buildObservable()).thenReturn(Observable.just(mockList));
		doAnswer(RxAnswer.onNextCompleted(mockList)).when(mockMainGalleryInteractor).execute(any());

		presenter.loadData();

		Mockito.verify(mockView).hideLoading();
		Mockito.verify(mockView).updateRecycler(mockList);
		Mockito.verify(mockMainGalleryInteractor).execute(any());
		Mockito.verify(mockView).showLoading();
	}

	@Test
	public void testDispose(){

		presenter.detachView();
		verify(mockMainGalleryInteractor).dispose();


	}


}