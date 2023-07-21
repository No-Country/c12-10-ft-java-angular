export interface respReview {
  success: boolean;
  message: string;
  data:    Review[];
}

export interface Review {
  id:          string;
  userId:      string;
  ownershipId: string;
  comment:     string;
  postDate:    string;
  score:       string;
}
