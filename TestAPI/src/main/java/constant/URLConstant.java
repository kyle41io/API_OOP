package constant;

public class URLConstant {
    public static final String TOKEN_TYPE = "Bearer ";
    public static final String DEFAULT_URL = "https://auctions-app-2.herokuapp.com/api";
    public static final String DEFAULT_IMAGE_URL = "https://res.cloudinary.com/daqvhmyif/image/upload/v1650429693/" +
            "wtatjbj7jhpueicdrg6n.jpg";

    public static final String LOGIN_URL = "/login";
    public static final String SIGN_UP_URL = "/signup";
    public static final String EDIT_ACCOUNT_URL = "/edit";
    public static final String LOGOUT_URL = "/logout";

    public static final String GET_LIST_AUCTION_URL = "/auctions";

    //API 7 to 12
    public static final String LIST_AUCTION_BY_USER = "/auctions/listAuctionsByUser";
    public static final String LIST_AUCTION_BY_STATUS = "/auctions/listAuctionsByStatus";
    public static final String LIST_AUCTION_BY_TYPE = "/auctions/listAuctions";
    public static final String GET_DETAIL_AUCTION = "/auctions/detail";
    public static final String CREATE_AUCTION_URL = "/auctions/create";
    public static final String EDIT_AUCTION = "/auctions/edit";

    //API 13 to 18
    public static final String GETLISTCOMMENTS_URL = "/comments";

    public static final String CREATE_ITEM_URL = "/items/create";

    public static final String CREATECOMMENT_URL = "/comments/create";

    public static final String CREATEBID_URL = "/bids/create";

    public static final String GETLISTBID_URL = "/bids";

    public static final String GETLISTCATEGORIES_URL = "/categories";

    //API 25 to 30
    public static final String GET_NEWS_URL = "/news";
    public static final String READ_NEWS_URL = "/news/read/";
    public static final String GET_NOTIFICATIONS_URL = "/notifications";
    public static final String READ_NOTIFICATIONS_URL = "/notifications/read/";
    public static final String GET_SLIDER_URL = "/slider";
    public static final String SEARCH_URL = "/search";
}
