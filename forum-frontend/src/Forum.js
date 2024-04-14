import React, {Component} from "react";
import Search from "./Search";
import Post from "./Post";
import axios from "axios";
import PostData from "./PostData";
import CreatePost from "./CreatePost";

const BASE_URL = "http://localhost:8080/";

class Forum extends Component{
   
    constructor(props){
        super(props);
        this.state = {posts:[], postData: {}, isClicked: false}
        this.searchPost = this.searchPost.bind(this);
        this.showDataOfPost = this.showDataOfPost.bind(this);
        this.createPost = this.createPost.bind(this);
    }
    componentDidMount(){
        // TODO:  Display some initial posts
    }
    async showDataOfPost(id){
        const getParticularPostUrl = `${BASE_URL}post/${id}`
        console.log(getParticularPostUrl)
        let postData = await axios.get(getParticularPostUrl,{
            headers: {
                Accept: "application/json"
            }
        })
        console.log(postData.data);
        this.setState({
            postData: postData.data,
            isClicked: true
        })
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
        posts: listOfPost.data,
        isClicked: false
       })
       console.log(listOfPost.data);

    }
    async createPost(query){
        const createPostURL = `${BASE_URL}post`;
        const response = await axios.post(createPostURL, {
            userId: parseInt(query.userId),
            text: query.post
        })
        this.setState({
            postData: response.data,
            isClicked: true
        })
    }
    render(){
        const posts = this.state.posts.map(st => {
            return <Post key={st.postId} data={st} showDataOfPost={this.showDataOfPost}/>
        })
        console.log(this.state.postData.length);
        return(
            <div>
                <Search searchPost={this.searchPost}/>
                <CreatePost createPost={this.createPost}/>
                {this.state.isClicked === false ? posts : <PostData data={this.state.postData}/>}
            </div>
        )
    }
}

export default Forum;