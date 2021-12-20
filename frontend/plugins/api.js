import User from "~/api/user"
import Storage from "~/api/storage";
import Explore from "~/api/explore";

export default (context, inject) => {
  const factories = {
    user: User(context.$axios),
    storage: Storage(context.$axios),
    explore: Explore(context.$axios)
  }

  inject("api", factories)
};
