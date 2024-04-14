import React, {Component} from "react";
import Search from "./Search";
import Post from "./Post";
import axios from "axios";

const BASE_URL = "http://localhost:8080/";

class Forum extends Component{
   
    constructor(props){
        super(props);
        this.state = {posts:[]}
        this.searchPost = this.searchPost.bind(this);
    }
    componentDidMount(){
        // TODO:  Display some initial posts
    }
    async searchPost(query){
       // TODO An api call to find all posts with search query
       let textToSearch = query.searchQuery;
       const searchPostUrl = `${BASE_URL}search?searchText=${textToSearch}`
       const listOfPost = await axios.get(searchPostUrl, {
        headers: {
            Accept: "application/json"
        }
       })
       this.setState({
        posts: listOfPost.data
       })
       console.log(listOfPost.data);

    }
    render(){
        const posts = this.state.posts.map(st => {
            return <Post data={st}/>
        })
        return(
            <div>
                <Search searchPost={this.searchPost}/>
                {posts}
            </div>
        )
    }
}

export default Forum;