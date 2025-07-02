package clientreview;

import org.testng.annotations.Test;
import com.clientreview.pages.NavigationToClientReviewPage;

import basepackage.Base;

public class NavigationToClientReview extends Base {

    private NavigationToClientReviewPage navigationPage;

    public NavigationToClientReview() {
        super();
    }
    @Test(priority = 2)
    public void setUpNavigation() {
        waitForSpinnerToDisappear();
//wi
        navigationPage = new NavigationToClientReviewPage(driver);
        navigationPage.OpenSideMenuScreen();
        navigationPage.navaigateToReports();
        navigationPage.ClickToClientScreen();
        
    }

    
    @Test(priority = 3)
    public void searchPreExisted() {
        waitForSpinnerToDisappear();

        navigationPage.SearchElementClick();
    }

    @Test(priority = 4)
    public void searchWithCategoryFilter() throws InterruptedException {
        waitForSpinnerToDisappear();

        Thread.sleep(2000);
        navigationPage.CategoryFilterSearch();
        navigationPage.DeSelectFilter();
        navigationPage.Selectcategory();
        navigationPage.myTeamRadioButton();
        navigationPage.SearchElementClick();
    }

    @Test(priority = 5)
    public void markReviews() {
        waitForSpinnerToDisappear();

        navigationPage.PendingReviewCount();
        navigationPage.EllipsisClick();
        navigationPage.MarkReviewNavigation();
        navigationPage.discussionPoint();
        navigationPage.selectDiscussionPoint();
        navigationPage.datePicker();
        navigationPage.enterDate();
        navigationPage.commentAdd();
        navigationPage.saveMarkreview();
    }
}
