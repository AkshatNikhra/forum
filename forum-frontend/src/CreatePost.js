import React, {Component, useId} from "react";

class CreatePost extends Component{
    constructor(props){
        super(props);
        this.state={userId: "", post: ""};
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }
    handleChange(evt){
        this.setState({
            [evt.target.name]: evt.target.value
        })
    }
    handleSubmit(evt){
        evt.preventDefault();
        this.props.createPost(this.state);
        this.setState({
            userId: "",
            post: ""
        });
    }
    render(){
        return(
            <div>
                <label htmlFor="post">New Post</label>
                <form onSubmit={this.handleSubmit}>
                    <input 
                        type="text"
                        placeholder="createPost"
                        name="post"
                        id="post"
                        value={this.state.post}
                        onChange={this.handleChange}
                    />
                    <input 
                         type="text"
                         placeholder="userId"
                         name="userId"
                         id="userId"
                         value={this.state.userId}
                         onChange={this.handleChange}
                    />
                    <button>Post</button>
                </form>
            </div>
            
        )
    }
}

export default CreatePost;