export interface respPicture {
  success: boolean;
  message: string;
  data:    Picture;
}

export interface Picture {
  id:          string;
  ownershipId: string;
  images:      string[];
}
