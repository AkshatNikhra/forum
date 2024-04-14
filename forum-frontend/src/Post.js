import React, {Component} from "react";
import axios from "axios";

const BASE_URL = "http://localhost:8080/";

class Post extends Component{
    constructor(props){
        super(props);
        this.handleClick = this.handleClick.bind(this);
    }
    handleClick(evt){
        this.props.showDataOfPost(this.props.data.postId);    
    }
    render(){
        return(
            <div>
                <h1 onClick={this.handleClick}>{this.props.data.text}</h1>
            </div>
        )
    }
}

export default Post;